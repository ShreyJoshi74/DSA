class Solution {
public:
    vector<bool> subsequenceSumAfterCapping(vector<int>& a, int k) {
        int n = a.size();
        sort(a.begin(), a.end());   // Sort array so smaller numbers are processed first

        vector<int> dp(k+1, 0);
        dp[0] = 1;  // Base case: sum 0 is always possible

        vector<bool> ans;
        int p = 0;  // pointer to processed elements

        // Iterate over prefix lengths
        for (int i = 1; i <= n; i++) {

            // Process all elements <= i
            while (p < n && a[p] <= i) {
                int v = a[p];
                for (int j = k; j >= v; j--) {
                    if (dp[j - v]) dp[j] = 1;
                }
                p++;
            }

            // Check if k is achievable (directly or with remaining elements)
            bool f = false;
            int rem = n - p; // elements not yet processed

            for (int j = 0; j <= rem && j * i <= k; j++) {
                if (dp[k - j * i]) {
                    f = true;
                    break;
                }
            }

            ans.push_back(f);
        }

        return ans;
    }
};
