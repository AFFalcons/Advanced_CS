import java.util.HashMap;

public class LinkedTree {

	 int[] leafs;
	 int cur;
	 HashMap<Integer, Integer> Count;

	
	    public LinkedTree(int[] leafs)
	    {
	        Count = new HashMap<>();
	        this.leafs = leafs;
	        cur = 0;
	    }

	    public void leftTreeNode(TreeNode par)
	    {
	        cur++;
	        if(leafs[cur] == -1)
	            return;
	        par.left = new TreeNode(par.pos-1, leafs[cur]);
	        Check(par.left);
	    }

	    public void rightTreeNode(TreeNode par)
	    {
	        cur++;
	        if(leafs[cur] == -1)
	            return;
	        par.right = new TreeNode(par.pos+1, leafs[cur]);
	        Check(par.right);
	    }

	    public String Out()
	    {
	        int low = 0;
	        String out = "";
	        for(Integer i : Count.keySet())
	        {
	            if(i < low)
	                low = i;
	        }

	        int x = low;
	        while(Count.containsKey(x))
	        {
	            out += Count.get(x) + " ";
	            x++;
	        }

	        return out;
	    }
	    
	    public void populate()
	    {
	        TreeNode root = new TreeNode(0, leafs[0]);
	        Check(root);
	    }
	    
	    public void Check(TreeNode par)
	    {
	        int i = 0;
	        if(Count.get(par.pos) != null)
	            i = Count.get(par.pos);
	        Count.put(par.pos, i + leafs[cur]);
	        leftTreeNode(par);
	        rightTreeNode(par);
	    }
	 
	public class TreeNode
    {
        TreeNode left, right;
        int numleaves;
        int pos;

        public TreeNode(int pos, int leaves)
        {
            this.pos = pos;
            this.numleaves = leaves;
        }
    }
}
