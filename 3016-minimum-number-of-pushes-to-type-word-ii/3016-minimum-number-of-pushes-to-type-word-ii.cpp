class Solution {
public:
    int minimumPushes(string word) {
        
        vector<int>arr;
        unordered_map<char,int>hashmap;
        for (char c:word)
        {
            hashmap[c]++;

        }
       for(auto &val:hashmap)
       {
        arr.push_back(val.second);
       }
       
       sort(arr.begin(),arr.end(),greater<int>());
       int ans=0;
       for(int i=0;i<arr.size();i++)
       {
         std::cout << arr[i];
         ans+=arr[i]*(1+ (i/8));
       }
    
       return ans;
    }
};