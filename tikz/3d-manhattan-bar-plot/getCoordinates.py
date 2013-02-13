def writeCoordinates(file, x, y, z):
    file.write("(" + str(x) + "," + str(y) + "," + str(z) + ") ")

def make3dhistogram(x, y, z, zmin, output):
    file = open(output, 'wb')
    i = 0
    for j in range(len(y)):
        writeCoordinates(file, x[i], y[j], zmin)
        writeCoordinates(file, x[i], y[j], zmin)
    file.write("\n\n")
    for i in range(len(x)-1):
        writeCoordinates(file, x[i], y[0], zmin)
        for j in range(len(y)-1):
            writeCoordinates(file, x[i], y[j], z[i][j])
            writeCoordinates(file, x[i], y[j+1], z[i][j])
        writeCoordinates(file, x[i], y[len(y)-1], zmin)
        writeCoordinates(file, x[i+1], y[0], zmin)
        file.write("\n\n")
        for j in range(len(y)-1):
            writeCoordinates(file, x[i+1], y[j], z[i][j])
            writeCoordinates(file, x[i+1], y[j+1], z[i][j])
        writeCoordinates(file, x[i+1], y[len(y)-1], zmin)
        file.write("\n\n")

    i = len(x)-1
    for j in range(len(y)):
        writeCoordinates(file, x[i], y[j], zmin)
        writeCoordinates(file, x[i], y[j], zmin)

def createTex(x, y, z, output='3d-manhattan-bar-plot.tex'):
    template = open('template.tpl', 'r').read()
    make3dhistogram(x, y, z, 0.0, 'data')
    data = open('data', 'r').read()
    file = open(output, 'wb')
    template = template.replace('[PLACE_PLOT_HERE]', data)
    template = template.replace('[XMAX]', str(len(x)-1))
    template = template.replace('[YMAX]', str(len(y)-1))
    file.write(template)

if __name__ == "__main__":
    x = [0,1,2,3,4] # Whats that good for? Can it be replaced by range(xMax+1)?
    y = [0,1,2,3,4] # Whats that good for? Can it be replaced by range(yMax+1)?
    z = [[2,3,1,0], [0,6,0,0], [1,0,0,4], [0,0,0,0]]
    createTex(x,y,z)
