class Disjoint{
    int n;
    int[] size;
    int[] parent;
    Disjoint(int n){
        this.n = n;
        this.size = new int[n+1];
        this.parent = new int[n+1];
        for(int i =0; i <= n ; i++){
            size[i] = 1;
            parent[i] = i;
        }

    }
    public int findParent(int u){
        if(u == parent[u]) return u;
        u = findParent(parent[u]);
        return u;
    }
    public void unionBySize(int u ,int v){
    int ulp_u = findParent(u);
    int ulp_v = findParent(v);
    if(ulp_u == ulp_v) return;
    
    if(size[ulp_u] < size[ulp_v]){
        parent[ulp_u] = ulp_v;
        size[ulp_v] += size[ulp_u];
    } else {
        parent[ulp_v] = ulp_u;
        size[ulp_u] += size[ulp_v]; 
    }
    }
}
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int total = accounts.size();
        Map <String,Integer> mailUser = new HashMap<>();
        Disjoint ds = new Disjoint(total + 1);
        for(int i = 0; i < total; i++){
            for(int j = 1; j < accounts.get(i).size(); j++){
                String email = accounts.get(i).get(j);
                if(!mailUser.containsKey(email)){
                    mailUser.put(email,i);
                }else{
                    int real = mailUser.get(email);
                    ds.unionBySize(real,i);
                }
            }
        }
        Map<Integer,TreeSet<String>> userMails = new HashMap<>();
        for(Map.Entry<String,Integer> e : mailUser.entrySet()){
            String email = e.getKey();
            int user = ds.findParent(e.getValue());
            if(!userMails.containsKey(user)){
                TreeSet<String> s = new TreeSet<>();
                s.add(email);
                userMails.put(user,s);
            }else{
                TreeSet<String> temp = userMails.get(user);
                temp.add(email);
                userMails.replace(user,temp);
            }
        }
        List<List<String>> output = new ArrayList<>();
        int i = 0;
        for(Map.Entry<Integer,TreeSet<String>> e : userMails.entrySet()){
            int user = e.getKey();
            TreeSet<String> temp = e.getValue();
            output.add(new ArrayList<>());
            String userName = accounts.get(user).get(0);
            output.get(i).add(userName);
            for(String p : temp){
                output.get(i).add(p);
            }
            i++;

        }
        return output;

    }
}