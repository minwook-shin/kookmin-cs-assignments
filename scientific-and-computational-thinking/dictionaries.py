dic = {}

dic.update({"Alpha": "알파", "Beta": "베타", "Gamma": "감마", "Delta": "델타", "Epsilon": "엡실론", "Zeta": "제타", "Eta": "에타",
            "Theta": "세타", "Iota": "요타", "Kappa": "카파", "Lambda": "람다", "Mu": "뮤", "Nu": "뉴", "Xi": "크사이",
            "Omicron": "오미크론", "Pi": "파이", "Rho": "로", "Sigma": "시그마", "Tau": "타우", "Upsilon": "입실론", "Phi": "피",
            "Chi": "카이", "Psi": "프사이", "Omega": "오메가"})

print("value (key)")
print("------------------------")
for key in dic:
    print(dic[key], "(", key, ")")
    print("------------------------")
try:
    s = input("enter korean value >>")
    print(dic[s])
except:
    print("wrong key!")
