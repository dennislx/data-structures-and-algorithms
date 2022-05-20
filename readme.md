## May 20

```sh
# add lecture branch
# 1. create a local branch named after lecture
# 2. add upstream branch to remote
# 3. fetch data from upstream branch (when two unrelated projects are trying to be merged) 
# 4. push to remote branch (default: lecture)

git checkout -b lecture              
git remote add upstream https://github.com/Berkeley-CS61B/lectureCode-fa20.git
git pull upstream master --allow-unrelated-histories  #don't understand why this has to be master?
git push origin lecture
```