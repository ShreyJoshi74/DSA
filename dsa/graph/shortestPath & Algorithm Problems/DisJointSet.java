
class Disjoint{
    int n;
    int[] rank;
    int[] parent;
    Disjoint(int n){
        this.n = n;
        rank = new int[n+1];
        parent = new int[n+1];
        for(int i = 0; i <= n; i++){
            rank[i] = 0;
            parent[i] = i;
        }
    }
    public int findParent(int u){
        if(u == parent[u]){
            return u;
        }
        parent[u] = findParent(parent[u]);
        return parent[u];
    }
    public void unionByRank(int u, int v){
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);
        if(ulp_u == ulp_v) return;
        if(rank[ulp_u] < rank[ulp_v]){
            parent[ulp_u] = ulp_v;
        }else if(rank[ulp_u] > rank[ulp_v]){
            parent[ulp_v] = ulp_u;
        }else{
            parent[ulp_v] = ulp_u;
            rank[ulp_u]++;
        }
    }
}
public class Main
{
	public static void main(String[] args) {
		System.out.println("Hello World");
		Disjoint ds = new Disjoint(7);
		ds.unionByRank(1,2);
		ds.unionByRank(2,3);
		ds.unionByRank(4,5);
		ds.unionByRank(6,7);
		if(ds.findParent(3) == ds.findParent(7)){
		    System.out.println("Yes Same Set");
		}else{
		    System.out.println("Not Same Set");
		}
		ds.unionByRank(5,6);
		ds.unionByRank(3,7);
		if(ds.findParent(3) == ds.findParent(7)){
		    System.out.println("Yes Same Set");
		}
	}
}
