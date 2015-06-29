class Solution {
        public:
                int majorityElement(vector<int> &num) {
                        unsigned nElement = num.size(); // 6
                        unsigned targetIdx = nElement / 2; // 3
                        return findKthElement( num, 0, nElement - 1, targetIdx ); // targetIdx 是从 start位置开始计算，而非从0位置开始。
                }
        private:
                int findKthElement( vector<int> &num, unsigned start,
                                unsigned end, unsigned target ) {
                        unsigned partitionIdx = partition( num, start, end ); // 0 // 1
                        if( partitionIdx < target )
                                return findKthElement( num, start + partitionIdx+1, end, target - partitionIdx - 1 );// 格外注意下标
                        if( partitionIdx > target )
                                return findKthElement( num, start, start + partitionIdx-1, target );
                        return num[ partitionIdx + start ];
                                }
                unsigned partition( vector<int> &num, unsigned start, unsigned end ) {
                    int leftIdx = start - 1; // -1 // 0
                    int rightIdx = start;// 0 // 1
                    int target = num[ end ]; // 2 // 2
                    while( rightIdx < end ) {
                        if( num[ rightIdx ] < target )
                        {
                            leftIdx ++;
                            swap( num, leftIdx, rightIdx );
                        }
                        rightIdx ++; // 1
                    }
                    leftIdx ++; // 0 // 1
                    swap( num, leftIdx, rightIdx );
                    return leftIdx - start; // 注意：返回值是在 start - end 区间中的第几个.
                }
                void swap( vector<int> &num, unsigned index1, unsigned index2 ) {
                    int buffer;
                    buffer = num[ index1 ];
                    num[ index1 ] = num[ index2 ];
                    num[ index2 ] = buffer;
                }
};