------------------------------------------------------------------------
This is the project README file. Here, you should describe your project.
Tell the reader (someone who does not know anything about this project)
all they need to know. The comments should usually include at least:
------------------------------------------------------------------------

PROJECT TITLE:  Java Lab-9 final
PURPOSE OF PROJECT: Practise question/Assignment
VERSION or DATE:    08-03-2025
HOW TO START THIS PROJECT:
AUTHORS:    23MCCE16
USER INSTRUCTIONS: Please see the images to see to how to give input
                    
Comparison : 

    Task 2 :-
        BinaryTree : 
                    1.Insert in BinaryTree is done by inserting in order from left to right in tree node
                      when an empty left or right child is found then new node is inserted there. By convention,
                      insertion always starts with left child node.
                      Time complexity of insertion is O(n) because we have to visit all n node to insert a new node.
                    
                    2.Searching is done by going to each node and returning true if its data is equal to the 
                      given value.
                      its time complexity is O(n) because we have to visit n node in worst case.
                    
                    3.Deleteion is done by visiting each node and if its data is equal to value then 
                      swap its data with the last node inserted then go to last node and delete it.
                      its time complexity is also O(n).
        
        BinarySearchTree :
                    1.Insertion in bst is done by using recursive method calling if the given node is greater
                      then the go to its left node else go to right node and at end insert at its left or right null position.
                      its time complexity is O(n) in the wrost case. In general O(log2(n)).
                    
                    2.Searching is done by taking advantage of bst property  and going as same process as insertion but
                      it will check if node data value is equal to given value.
                      its time complexity is O(n) in the wrost case. In general O(log2(n)).
                    
                    3.Deleteion is done by recursive method calling and it returns new root of bst it searches for its given 
                      value and replace it with its right node data if its present otherwise with its left node data and again 
                      give that replace node as argument for next recursive delete method with the replaced value.
                      its time complexity is O(n) in the wrost case. In general O(log2(n)).