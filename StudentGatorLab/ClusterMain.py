from graphics import*
from Button import*
import math

def loadData(win, label):
    if label:
        f = open("gatorDataUnlabeled.txt")
    allData = f.read()
    listData = allData.split()
    gators = []
    crocs = []
    for i in range(0, len(listData), 2):
        x = float(listData[i])
        y = float(listData[i+1])
        #lab = listData[i+1]
        m = float(2.9)
        if x > m:
            color = "red"
        else:
            color = "blue"
        p = Point(int(200 + x*100), int(500 - y*1.75))
        r = Rectangle(Point(p.getX() - 2, p.getY() - 2), Point(p.getX() + 2, p.getY() + 2))
        r.setFill(color)
        r.draw(win)

        #add data to lists
        if x > m:
            gators.append(r)
        else:
            crocs.append(r)
            
    return gators, crocs

def findCentroid(win, g, c):
    #calc centroids
    xc = 0
    yc = 0
    xg = 0
    yg = 0
    n = 0
    m = 0
    for ele in g:
        h = ele.getCenter()
        p = h.getX()
        xc = xc + p
        l = h.getY()
        yc = yc + l
        n = n + 1
    for ele in c:
        h = ele.getCenter()
        p = h.getX()
        xg = xg + p
        l = h.getY()
        yg = yg + l
        m = m + 1
    c1 = Point(xc/n, yc/n)
    c2 = Point(xg/m, yg/m)
        
    
    #draw centroids
    r1 = Rectangle(Point(c1.getX() - 4, c1.getY() - 4), Point(c1.getX() + 4, c1.getY() + 4))
    r1.setFill("darkred")
    r1.draw(win)
    r2 = Rectangle(Point(c2.getX() - 4, c2.getY() - 4), Point(c2.getX() + 4, c2.getY() + 4))
    r2.setFill("darkblue")
    r2.draw(win)

    return r1, r2

def distance(p1, p2):
    #calc distance between the two points
    p = p1.getX()
    py = p1.getY()
    f = p2.getX()
    fy = p2.getY()
    m = ((f-p)**2) + ((fy-py)**2)
    d = math.sqrt(m)
    return d

def cluster(g, c, cenG, cenC):
    gators = []
    crocs = []
    
    #calculate the cluster
    centG = cenG.getCenter()
    centC = cenC.getCenter()
    for h in g:
    
        l = h.getCenter()
        d1 = distance(l, centG)
        d2 = distance(l, centC)
        if d2 > d1:
            gators.append(h)
        else:
            crocs.append(h)

    for n in c:
        k = n.getCenter()
        d = distance(k, centG)
        d3 = distance(k, centC)
        if d3 > d:
            gators.append(n)
        else:
            crocs.append(n)
    for gt in gators:
        gt.setFill("red")
    for cr in crocs:
        cr.setFill("blue")
    return gators, crocs

def main():

    # Create Window
    win = GraphWin("Cluster Example", 800, 800)
    yAx = Line(Point(200, 100), Point(200, 540))
    yAx.draw(win)
    xAx = Line(Point(160, 500), Point(600, 500))
    xAx.draw(win)
    origin = Point(200, 500)
    yLabel = Text(Point(120, 280), "Mass (kg)")
    yLabel.draw(win)
    xLabel = Text(Point(400, 540), "Length (cm)")
    xLabel.draw(win)
    loadButton = Button(win, "Load Data", 80, Point(320, 630))
    quitButton = Button(win, "EXIT", 80, Point(140, 630))
    centButton = Button(win, "Centroid", 80, Point(500, 630))
    clusterButton = Button(win, "Cluster", 80, Point(680, 630))

    outputT = Text(Point(300, 50), "Welcome to the Gator / Crocodile Analyzer")
    outputT.draw(win)

    weightT = Text(Point(120, 720), "WEIGHT")
    weightT.draw(win)
    inputWeight = Entry(Point(240, 720), 20)
    inputWeight.draw(win)
    lengthT = Text(Point(360, 720), "LENGTH")
    lengthT.draw(win)
    inputLength = Entry(Point(480, 720), 20)
    inputLength.draw(win)
    inputButton = Button(win, "Test Data", 80, Point(660, 720))

    gators = []
    crocs = []
    cenG = Rectangle(Point(0,0), Point(1,1))
    cenC = Rectangle(Point(0,0), Point(1,1))

    while True:
        m = win.getMouse()
        if quitButton.isClicked(m):
            win.close()
            break
        
        if loadButton.isClicked(m):
            gators, crocs = loadData(win, True)

        if centButton.isClicked(m):
            cenG.undraw()
            cenC.undraw()
            cenG, cenC = findCentroid(win, gators, crocs)

        if clusterButton.isClicked(m):
            gators, crocs = cluster(gators, crocs, cenG, cenC)

        if inputButton.isClicked(m):
            w = float(inputWeight.getText())
            l = float(inputLength.getText())
            p = Point(int(200 + l*100), int(500 - w*1.75))
            d1 = distance(p, cenG.getCenter())
            d2 = distance(p, cenC.getCenter())
            if d1 < d2:
                outputT.setText("You have an Alligator weighing " + str(w) + " kg and " + str(l) + " meters long")
            else:
                outputT.setText("You have a Crocodile weighing " + str(w) + " kg and " + str(l) + " meters long")


if __name__ == "__main__":
    main()
