class Solution {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer>nums=new ArrayList<>();
        inorder(root,nums);
        int left=0,right=nums.size()-1;
        while(left<right){
            int sum=nums.get(left)+nums.get(right);
            if(sum==k) return true;
            if(sum<k) left++;
            else right--;
        }
        return false;
        
    }
    private void inorder(TreeNode root,List<Integer> nums){
        if(root==null) return;
        inorder(root.left,nums);
        nums.add(root.val);
        inorder(root.right,nums);
    }
}