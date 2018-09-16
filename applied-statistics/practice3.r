library(MASS)
painters

painters$School
class(painters)
class(painters$School)

school.freq = table(painters$School)
school.freq
class(school.freq)

cbind(school.freq)

a <- c("Sometimes","Sometimes","Never","Always","Always","Sometimes","Sometimes","Never")
b <- c("Maybe","Maybe","Yes","Maybe","Maybe","No","Yes","No")
results <- table(a,b)
results

school.relfreq = school.freq / nrow(painters)
school.relfreq

barplot(school.freq)
pie(school.freq)


school = painters$School
c_school = school == "C"
c_painters = painters[c_school, ]
c_painters
mean(c_painters$Composition, na.rm=FALSE)

head(faithful)

range(faithful$eruptions)

breaks = seq(1.5, 5.5, by=0.5)
breaks
cut(range(faithful$eruptions), breaks, right=FALSE)

duration = faithful$eruptions 
hist(duration, right=FALSE)

duration.relfreq = table(cut(duration, breaks, right=FALSE)) / nrow(faithful)
cbind(duration.relfreq)

duration.cumfreq = cumsum(table(cut(duration, breaks, right=FALSE)))
cbind(duration.cumfreq)

duration.cumfreq = cumsum(table(cut(duration, breaks, right=FALSE)))
cbind(duration.cumfreq)

cumfreq0 = c(0, cumsum(table(cut(duration, breaks, right=FALSE)))) 
plot(breaks, cumfreq0, main="Old Faithful Eruptions",xlab="Duration minutes",  ylab="Cumulative eruptions")   # y−axis label 
lines(breaks, cumfreq0)

aa = ecdf(duration)
plot(aa)

duration = faithful$eruptions 
stem(duration)

duration = faithful$eruptions 
waiting = faithful$waiting
head(cbind(duration, waiting))
plot(duration, waiting, xlab="Eruption duration", ylab="Time waited")

abline(lm(waiting ~ duration))

duration = faithful$eruptions 
mean(duration)
median(duration)

quantile(duration)
quantile(duration,c(.32))

range(duration)
IQR(duration)

boxplot(duration, horizontal=TRUE)

var(duration)

sd(duration)