# head(cars)
plot(formula = cars$dist ~ cars$speed ,data = cars,xlab = "speed",ylab ="dist",main="cars")
readline()

l = lm(formula = dist ~ speed, data = cars)
print(coef(l))
print(summary(l)$r.squared)
print(predict(l, newdata = data.frame(speed = c(19.5)), interval = "confidence"))
print(predict(l, newdata = data.frame(speed = c(19.5)), interval = "prediction"))
readline()

plot(formula = cars$dist ~ cars$speed ,data = cars,xlab = "speed",ylab ="dist",main="cars")

func = function(x){
	return(coef(l)["(Intercept)"] +coef(l)["speed"]*x)
}
curve( func ,add = T)