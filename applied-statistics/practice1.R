x = 1
x

x <- 2
x

c(1,2,3)

x = c(1,2,3)
x

x = 10.5
x
class(x)

k = 1
k
class(k)
is.integer(k)

y = as.integer(3)
y
class(y)
is.integer(y)

as.integer(3.14)
# as.integer("Joe")

as.integer(TRUE)

z = 1 + 2i
z
class(z)

# sqrt(-1)

sqrt(as.complex(-1))

x =1; y =2
z = x> y
z
class(z)

u = TRUE; v = FALSE
u & v
u | v
!u 

x = as.character(3.14)
x
class(x)

fname = "Joe"; lname = "smith"
paste(fname,lname, sep = " ")

sprintf("%s has %d dollars", "Sam", 100) 

substr("Mary has a little lamb.",start =3,stop=12)

sub("little", "big", "Mary has a little lamb.") 

c(2,3,5)
c(TRUE,FALSE,TRUE,FALSE,FALSE)
class(c(TRUE,FALSE,TRUE,FALSE,FALSE))

l = c("aa", "bb", "cc", "dd", "ee")

length(l)

n = c(2,3,5)
s = c("aa", "bb", "cc", "dd", "ee")

c(n,s)
class(c(n,s))

a = c(1, 3, 5, 7) 
b = c(1, 2, 4, 8)

5 * a
a + b
a - b
a * b
a / b

u = c(10, 20, 30) 
v = c(1, 2, 3, 4, 5, 6, 7, 8, 9) 
u + v

a = c(1,2);b = c(1,2,3)
# a+b

s = c("aa", "bb", "cc", "dd", "ee")
s[3]
class(s[3])
s[-3]

s[10]

s[c(2,3,3)]
s[c(2,1,3)]
s[2:4]

s = c("aa", "bb", "cc", "dd", "ee")
L = c(FALSE, TRUE, FALSE, TRUE, FALSE)
s[L]

v = c("mary","sue")
v
names(v) = c("first","ljast")
v

a = matrix(c(2,4,3,1,5,7), nrow = 2, ncol = 3, byrow = TRUE)
a

a[2,3]
a[2,]
a[,3]
a[,c(1,3)]

dimnames(a) =  list(c("row1","row2"),c("col1","col2","col3"))
a
a["row1","col2"]

b = matrix(c(2, 4, 3, 1, 5, 7), nrow=3, ncol=2)
b
t(b)

c = matrix( c(7, 4, 2), nrow=3, ncol=1)

cbind(c,b)

d = matrix( c(6, 2), nrow=1, ncol=2)

rbind(b,d)

c(b)

n = c(2, 3, 5) 
s = c("aa", "bb", "cc", "dd", "ee") 
b = c(TRUE, FALSE, TRUE, FALSE, FALSE) 
x = list(n, s, b, 3)
x
x[2]
x[c(2,4)]
x[[2]]
class(x[2])
class(x[[2]])

x[[2]][1] = "tt"
x[[2]]
s

v = list(bob=c(2, 3, 5), john=c("aa", "bb"))
v

v[c("john", "bob")]

v[["bob"]]

v$ bob

attach(v)
bob
detach(v)