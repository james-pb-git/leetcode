class Solution {
        public:
                int majorityElement(vector<int> &num) {
                        unsigned nElement = num.size(); // 6
                        unsigned targetIdx = nElement / 2; // 3
                        return findKthElement( num, 0, nElement - 1, targetIdx ); // targetIdx �Ǵ� startλ�ÿ�ʼ���㣬���Ǵ�0λ�ÿ�ʼ��
                }
        private:
                int findKthElement( vector<int> &num, unsigned start,
                                unsigned end, unsigned target ) {
                        unsigned partitionIdx = partition( num, start, end ); // 0 // 1
                        if( partitionIdx < target )
                                return findKthElement( num, start + partitionIdx+1, end, target - partitionIdx - 1 );// ����ע���±�
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
                    return leftIdx - start; // ע�⣺����ֵ���� start - end �����еĵڼ���.
                }
                void swap( vector<int> &num, unsigned index1, unsigned index2 ) {
                    int buffer;
                    buffer = num[ index1 ];
                    num[ index1 ] = num[ index2 ];
                    num[ index2 ] = buffer;
                }
};