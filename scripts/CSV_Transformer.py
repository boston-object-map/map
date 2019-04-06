import csv
import re

with open('streetlight-locations.csv') as file_in:
    with open('streetlight.csv', 'w', newline='') as file_out:
        reader = csv.reader(file_in)
        next(reader, None)
        fw = csv.writer(file_out)
        fw.writerow(['X', 'Y', 'ObjectID', 'Type'])
        for row in reader:
            loc = re.match(r'POINT \(([\d\.\-]+) ([\d\.\-]+)\)', row[0])
            x = float(loc.group(1))
            y = float(loc.group(2))
            fw.writerow([x, y, row[1], row[2]])

        print('done')

