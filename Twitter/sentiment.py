import glob
import pandas as pd

path = '/home/nlu/Desktop/sentiment_analysis/Twitter/Positive/*.txt'
files = glob.glob(path)
pos = []
for file in files:
    f = open(file, 'r')
    x = f.read()
    pos.append(x.strip())

df1 = pd.DataFrame(pos)
df1['label']='POS'
df1 = df1.rename(columns={0: 'text', 1: 'label'})
print(df1)


path = '/home/nlu/Desktop/sentiment_analysis/Twitter/Negative/*.txt'
files = glob.glob(path)
neg = []
for file in files:
    f = open(file, 'r')
    x = f.read()
    neg.append(x.strip())

df2 = pd.DataFrame(neg)
df2['label']='NEG'
df2 = df2.rename(columns={0: 'text', 1: 'label'})
print(df2)

df = df1.append(df2, ignore_index=True)
print(df)
