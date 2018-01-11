import glob
import pandas as pd
from sklearn.utils import shuffle
from sklearn.naive_bayes import GaussianNB
path = '/home/nlu/Desktop/Sentiment Analysis/Twitter/Positive/*.txt'
files = glob.glob(path)
pos = []
for file in files:
    f = open(file, 'r')
    x = f.read()
    pos.append(x.strip())

df1 = pd.DataFrame(pos)
df1['label']='POS'
df1 = df1.rename(columns={0: 'text', 1: 'label'})

path = '/home/nlu/Desktop/Sentiment Analysis/Twitter/Negative/*.txt'
files = glob.glob(path)
neg = []
for file in files:
    f = open(file, 'r')
    x = f.read()
    neg.append(x.strip())

df2 = pd.DataFrame(neg)
df2['label']='NEG'
df2 = df2.rename(columns={0: 'text', 1: 'label'})

from sklearn.model_selection import train_test_split

train1, test1 = train_test_split(df1, test_size = 0.2)
train2, test2 = train_test_split(df2, test_size = 0.2)

train = train1.append(train2, ignore_index=True)
test = test1.append(test2, ignore_index=True)

train = shuffle(train)
test = shuffle(test)

train_arr = []
test_arr = []
train_lbl = []
test_lbl = []

train_arr=train['text'].astype(str)
train_lbl=train['label'].astype(str)
test_arr=test['text'].astype(str)
test_lbl=test['label'].astype(str)

from sklearn.feature_extraction.text import CountVectorizer, TfidfTransformer,TfidfVectorizer

vectorizer = TfidfVectorizer()
train_vec = vectorizer.fit_transform(train_arr)
test_vec = vectorizer.transform(test_arr)

from sklearn.svm import LinearSVC
from sklearn.naive_bayes import BernoulliNB, GaussianNB, MultinomialNB
from sklearn import tree

#SVM train
lsvm=LinearSVC()
lsvm.fit(train_vec,train_lbl)

#Naive Bayes train
clf = GaussianNB()
clf.fit((train_vec.toarray()),train_lbl)

#DecisionTree train
tree_clf = tree.DecisionTreeClassifier()
tree_clf.fit(train_vec,train_lbl)

y_pred_clf=clf.predict(test_vec.toarray())
y_pred_lsv=lsvm.predict(test_vec)
y_pred_dct=tree_clf.predict(test_vec)

test=[' انت سيء']
test_tfstr = vectorizer.transform(test)

from sklearn.metrics import  accuracy_score
from sklearn import metrics
print("CLF accuracy:", metrics.accuracy_score(test_lbl,y_pred_clf))
print("CLF Tes Tcase:", clf.predict(test_tfstr.toarray())[0])
print("******************************************************")
print("SVM accuracy:", metrics.accuracy_score(test_lbl,y_pred_lsv))
print("SVM Tes Tcase:", lsvm.predict(test_tfstr.toarray())[0])
print("******************************************************")
print("DCT accuracy:", metrics.accuracy_score(test_lbl,y_pred_dct))
print("DCT Tes Tcase:", tree_clf.predict(test_tfstr.toarray())[0])
'''
vectorizer = CountVectorizer()
vectorizer.fit(train_arr)
train_mat = vectorizer.transform(train_arr)

tfidf = TfidfTransformer()
tfidf.fit(train_mat)
train_tfmat = tfidf.transform(train_mat)

test_mat = vectorizer.transform(test_arr)
test_tfmat = tfidf.transform(test_mat)

print(test_tfmat.shape)
#clf = GaussianNB()
#clf.fit(train_tfmat,train_lbl)
#y_pred_clf=clf.predict(test_tfmat)

from sklearn.svm import LinearSVC

lsvm=LinearSVC()
lsvm.fit(train_tfmat,train_lbl)

y_pred_lsvm=lsvm.predict(test_tfmat)

from sklearn.metrics import  accuracy_score
from sklearn import metrics
print("accuracy:", metrics.accuracy_score(test_lbl, y_pred_lsvm))

test=['انا احب هذا المعلم']
test_str = vectorizer.transform(test)
test_tfstr = tfidf.transform(test_str)
test_tfstr.shape
print(lsvm.predict(test_tfstr.toarray())[0])
'''
