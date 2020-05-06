package subtask6

class FullBinaryTrees {

    class TreeNode(var value: Int = 0) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun stringForNodeCount(count: Int): String {

        val result = StringBuilder("[")
        allPossiblTrees(count).forEach{ result.append("${tree2str(it)}") }
        result.append("]")
        return result.toString()
    }

    fun allPossiblTrees(n: Int): List<TreeNode?> {
        if(n % 2 == 0) return ArrayList()
        if(n == 1) return arrayListOf(TreeNode())
        val result = ArrayList<TreeNode>()
        for(numberOfNodesInSubtree in 1 until n-1 step 2){
            val leftSubTree = allPossiblTrees(numberOfNodesInSubtree)
            val rightSubTree = allPossiblTrees(n - 1 - numberOfNodesInSubtree)
            for(leftSubTreeNode in leftSubTree){
                for(rightSubTreeNode in rightSubTree){
                    val root = TreeNode()
                    root.left = leftSubTreeNode
                    root.right = rightSubTreeNode
                    result.add(root)
                }
            }
        }
        return result
    }
    fun tree2str(treeNode: TreeNode?): String {
        val result = ArrayList<Int?>()
        result.add(0)
        val nodes = ArrayList<TreeNode?>()
        nodes.add(treeNode?.left)
        nodes.add(treeNode?.right)
        while(nodes.isNotEmpty()){
            val subNodes = ArrayList<TreeNode?>()
            for(node in nodes){
                if(node == null) result.add(null)
                else{
                    result.add(0)
                    subNodes.add(node.left)
                    subNodes.add(node.right)
                }
            }
            nodes.clear()
            nodes.addAll(subNodes)
            subNodes.clear()
        }

        while (result.last() == null) result.removeAt(result.lastIndex)
        return result.toString()
    }
}
