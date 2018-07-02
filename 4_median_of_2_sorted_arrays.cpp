//https://leetcode.com/problems/median-of-two-sorted-arrays/description/
class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        std::vector<int> fin;
        // 1,3
        // 2
        int i = 0;
        int j = 0;
        while( i < nums1.size() && j < nums2.size() )
        {
                if (nums1[i] < nums2[j])
                {
                    fin.push_back(nums1[i]);
                    i++;                        

                }
                else
                {
                    fin.push_back(nums2[j]);
                    j++;    
                }
        }
        while ( i < nums1.size())
        {
            fin.push_back(nums1[i]);
            i++;
        }
        
        while ( j < nums2.size())
        {
            fin.push_back(nums2[j]);
            j++;
        }
        
                for (int i =0; i < fin.size(); i++)
        {
            cout << fin[i] << " ";
        }
        
        if (fin.size() % 2 == 0)
        {
            //even
            int size = ceil( (fin.size() - 1) /2);
            cout << "size is:" << size;
            int first = fin[size];
            int second = fin[size + 1];
            return ((double)first + (double)second)/2;
            
        }
        else
        {
            return fin[ (fin.size() - 1)/2 ];
        }
    }
};