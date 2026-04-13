class Solution {
    public int countComponents(int n, int[][] edges) {
       Unionfind union = new Unionfind(n);

       for(int[] edge : edges){
        union.union(edge[0], edge[1]);
       }

       return union.getCount();
    }
}

class Unionfind{

    int[] parent;
    int count;

    Unionfind(int n){
        parent = new int[n];
        count = n;
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
    }

    public int findParent(int child){
        if(child != parent[child]){
            parent[child] = findParent(parent[child]);
        }
        return parent[child];
    }


    public void union(int u, int v){
        int parentU = findParent(u);
        int parentV = findParent(v);

        if(parentU == parentV) return;

        parent[parentV] = parentU;
        count--;
    }

    public int getCount(){
        return count;
    }

}

