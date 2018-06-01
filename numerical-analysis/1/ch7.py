number = 23
guess = int(input('Enter an integer : '))
if guess == number:
    print ('Congratulations, you guessed it.')
    print ('(but you do not win any prizes!)')
elif guess < number:
    print ('No, it is a little higher than that')
else:
    print ('No, it is a little lower than that')

print ('Done')

if True:
    print ('Yes, it is true')


number = 23
running = True
while running:
    guess = int(input('Enter an integer : '))
    if guess == number:
        print ('Congratulations, you guessed it.')
        running = False
    elif guess < number:
        print ('No, it is a little higher than that.')
    else:
        print ('No, it is a little lower than that.')
else:
    print ('The while loop is over.')
print ('Done')

for i in range(1, 5):
    print (i)
else:
    print ('The for loop is over')


while True:
    s = input('Enter something : ')
    if s == 'quit':
        break
    print ('Length of the string is', len(s))
print ('Done')

while True:
    s = input('Enter something : ')
    if s == 'quit':
        break
    if len(s) < 3:
        print ('Too small')
        continue
    print ('Input is of sufficient length')