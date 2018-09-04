n = c(2, 3, 5) 
s = c("aa", "bb", "cc") 
b = c(TRUE, FALSE, TRUE) 
df = data.frame(n, s, b)

df

mtcars

nrow(mtcars)
ncol(mtcars)

mtcars[["am"]]
mtcars$am
mtcars[[9]]
mtcars[,9]
mtcars[9]

mtcars[c("mpg","hp")]

mtcars[24,]

l = mtcars$am == 0
l

mtcars[l,]

library(gdata)

mydata = read.xls("st_data.xls")
mydata

getwd()

nrow(mydata)
ncol(mydata)

c = 20171640 %% 50

c

mydata[c,]

r = 20171640 %% 4 + 3

mydata[r]