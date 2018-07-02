//https://leetcode.com/problems/string-to-integer-atoi/description/

class Solution {
public:
    int myAtoi(string str) {
        int sign = 1;
        bool began = false;
        int final_num = 0;
        int pop = 0;
        for (int i = 0; i < str.size(); i++)
        {
            if (str[i] == ' ')
            {
                cout << "space ";
                if(began)
                    break;
                continue;
            }
            
            if (str[i] == '+')
            {   
                cout << "plus ";
                if(began)
                    break;
                sign = 1;
                began = true;
                continue;
            }

            if (str[i] == '-')
            {
                cout << "minus ";
                if(began)
                    break;
                sign = -1;
                began = true;
                continue;
            }

            if ('0' <= str[i] && str[i] <= '9')
            {
                cout << "char ";
                //if numeric
                began = true;
                
                pop = (str[i] - '0') * sign;
                cout << pop << " ";
                if (final_num > INT_MAX/10 || (final_num == INT_MAX/10 && pop > 7))
                {
                    return INT_MAX;
                }
                if (final_num < INT_MIN/10 || (final_num == INT_MIN/10 && pop < -8))
                {
                    return INT_MIN;
                }
                
                final_num = final_num * 10 + pop;
                cout << final_num << " ";
            }
            else
            {
                break;
            }
        }
        return final_num;
    }
};