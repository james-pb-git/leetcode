class BinaryTreePruning(object):

    def __prune_tree_recursive__(self, root):
        if root is None:
            return False
        if root.val == 0 and root.left is None and root.right is None:
            return False
        res_left = self.__prune_tree_recursive__(root.left)
        res_right = self.__prune_tree_recursive__(root.right)
        if not res_left:
            root.left = None
        if not res_right:
            root.right = None
        if (not res_left) and (not res_right) and root.val == 0:
            return False
        return True

    def pruneTree(self, root):
        """
        :type root: TreeNode
        :rtype: TreeNode
        """
        self.__prune_tree_recursive__(root)
        return root