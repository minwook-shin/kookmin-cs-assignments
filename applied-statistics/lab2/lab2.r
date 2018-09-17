library(gdata)
mydata = read.xls("st_data.xls")
midterm = mydata$Midterm
final = mydata$Final
breaks = seq(0, 100, 10) 

first = cut(midterm,breaks,right = FALSE)
print(cbind(table(first)))
readline()

hist(midterm)
readline()

plot(midterm,final,xlab = "Midterm Exam",ylab = "Final Exam")
readline()

print(mean(midterm))
print(var(midterm))
print(sd(midterm))
readline()