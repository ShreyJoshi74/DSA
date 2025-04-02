class Pair{
    Node root; 
    int depth;
    int hc;
    Pair(Node a,int b,int c){
        root = a;
        depth = b;
        hc = c;
    }
}
class Solution
{   
    
    Map<Integer,Pair> map = new HashMap<>();
    
    public void levelOrder(Node root, int hc,int depth){
        if(root == null){
            return;
        }
        
        if(map.containsKey(hc)){
                Pair temp = map.remove(hc);
                Node troot = temp.root;
                int     tdepth = temp.depth;
                int thc = temp.hc;
                if(tdepth > depth){
                    map.put(hc,temp);
                }else{
                    map.put(hc,new Pair(root,depth,hc));
                }
            }else{
                map.put(hc,new Pair(root,depth,hc));
            }
            
            
        levelOrder(root.left,hc-1,depth+1);
        levelOrder(root.right,hc+1,depth + 1);
        return;
    }
    public ArrayList <Integer> bottomView(Node root){
        levelOrder(root,0,0);
        ArrayList<Integer> arr = new ArrayList<>();
        Set<Integer> ls = map.keySet();
        TreeSet<Integer> treeset = new TreeSet<>(ls);
        for(Integer q:treeset){
            Pair temp = map.get(q);
            int data = temp.root.data;
            arr.add(data);
        }
        return arr;
    }
       
}
