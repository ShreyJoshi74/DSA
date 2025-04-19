// Contains both union by size and rank
// I personally feel union by size is more intuitive than union by rank
// you can feel size approach ranther than rank
class Disjoint{
    int n;
    int[] rank;
    int[] parent;
    int[] size;
    Disjoint(int n){
        this.n = n;
        rank = new int[n+1];
        parent = new int[n+1];
        size = new int[n+1];
        for(int i = 0; i <= n; i++){
            rank[i] = 0;
            parent[i] = i;
            size[i] = 1;
        }
    }
    public int findParent(int u){
        if(u == parent[u]){
            return u;
        }
        parent[u] = findParent(parent[u]);
        return parent[u];
    }
  // rank wali approach
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
    // size wali liye
    public void unionBySize(int u, int v){
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);
        if(ulp_u == ulp_v) return;
        if(size[ulp_u] < size[ulp_v]){
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
        }else{
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
        }
    }
}
public class Main
{
	public static void main(String[] args) {
		System.out.println("Hello World");
		Disjoint ds = new Disjoint(7);
		ds.unionBySize(1,2);
		ds.unionBySize(2,3);
		ds.unionBySize(4,5);
		ds.unionBySize(6,7);
		if(ds.findParent(3) == ds.findParent(7)){
		    System.out.println("Yes Same Set");
		}else{
		    System.out.println("Not Same Set");
		}
		ds.unionBySize(5,6);
		ds.unionBySize(3,7);
		if(ds.findParent(3) == ds.findParent(7)){
		    System.out.println("Yes Same Set");
		}
	}
}
