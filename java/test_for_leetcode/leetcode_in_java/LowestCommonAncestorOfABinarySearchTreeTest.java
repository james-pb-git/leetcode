package leetcode_in_java;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by bopang on 15/8/3.
 */
public class LowestCommonAncestorOfABinarySearchTreeTest {

    private LowestCommonAncestorOfABinarySearchTree lca;

    @Before
    public void setUp() throws Exception {
        lca = new LowestCommonAncestorOfABinarySearchTree();
    }

    @Test
    public void testLowestCommonAncestor() throws Exception {
        TreeNode root = new TreeNode( 3 );
        TreeNode n10 = new TreeNode( 1 );
        TreeNode n11 = new TreeNode( 4 );
        TreeNode n20 = new TreeNode( 0 );
        TreeNode n21 = new TreeNode( 2 );
        root.left = n10;
        root.right = n11;
        n10.left = n20;
        n10.right = n21;

        assertEquals( 3, lca.lowestCommonAncestor(root, root, root).val);
        assertEquals( 3, lca.lowestCommonAncestor(root, n10, n11).val);
        assertEquals( 1, lca.lowestCommonAncestor(root, n10, n20).val);
        assertEquals( 3, lca.lowestCommonAncestor(root, n20, n11).val);
        assertEquals( 1, lca.lowestCommonAncestor(root, n20, n21).val);
    }
}