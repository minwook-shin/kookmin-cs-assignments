library(gdata)

mydata = read.xls("st_data.xls")

a = nrow(mydata)
b = ncol(mydata)

paste(a, sep = " ", b)

c = 20170000 %% 50
r = 20170000 %% 4 + 3

mydata[c,]
mydata[r]