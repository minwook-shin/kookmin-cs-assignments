import turtle

s = turtle.Screen()
t = turtle.Turtle()

a = 30
m = 10


def draw(t, main_line):
    if main_line > 0:
        t.forward(main_line)
        t.left(a)
        draw(t, main_line - m)
        t.right(a)
        t.right(a)
        draw(t, main_line - m)
        t.left(a)
        t.backward(main_line)


line = 60
t.left(90)
draw(t, line)

turtle.done()
