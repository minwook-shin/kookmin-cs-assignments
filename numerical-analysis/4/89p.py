shoplist = ['apple', 'mango', 'carrot', 'banana']
print(shoplist[::1])
print(shoplist[::2])
print(shoplist[::3])
print(shoplist[::-1])

bri = set(['brazil', 'russia', 'india'])
print('india' in bri)
print('usa' in bri)
bric = bri.copy()
bric = bri.copy()
print(bric.issuperset(bri))
bri.remove('russia')
print(bri & bric)