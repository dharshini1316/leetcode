class Solution {
public:
    int minCost(vector<vector<int>>& grid, int k) {
        int n = grid.size(), m = grid[0].size();
        const int INF = 1e9;

        // cost[i][j] = minimum cost from (i,j) to (n-1,m-1)
        vector<vector<int>> cost(n, vector<int>(m, INF));

        // Flatten all cells
        vector<pair<int,int>> cells;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                cells.push_back({i, j});

        // Sort cells by grid value
        sort(cells.begin(), cells.end(),
             [&](auto &a, auto &b) {
                 return grid[a.first][a.second] <
                        grid[b.first][b.second];
             });

        // Base DP: normal grid transitions
        auto relaxGrid = [&]() {
            for (int i = n - 1; i >= 0; i--) {
                for (int j = m - 1; j >= 0; j--) {
                    if (i == n - 1 && j == m - 1) {
                        cost[i][j] = 0;
                        continue;
                    }
                    if (i + 1 < n)
                        cost[i][j] = min(cost[i][j],
                                         cost[i + 1][j] + grid[i + 1][j]);
                    if (j + 1 < m)
                        cost[i][j] = min(cost[i][j],
                                         cost[i][j + 1] + grid[i][j + 1]);
                }
            }
        };

        // Initial DP without special jumps
        relaxGrid();

        // Perform k rounds of value-based relaxation
        for (int step = 0; step < k; step++) {
            int best = INF;

            for (int idx = 0; idx < cells.size(); idx++) {
                int r = cells[idx].first;
                int c = cells[idx].second;

                best = min(best, cost[r][c]);

                // If next cell has same value, skip until group ends
                if (idx + 1 < cells.size() &&
                    grid[r][c] ==
                    grid[cells[idx + 1].first][cells[idx + 1].second]) {
                    continue;
                }

                // Propagate best cost backward across same-value group
                int back = idx;
                while (back >= 0 &&
                       grid[cells[back].first][cells[back].second]
                       == grid[r][c]) {
                    cost[cells[back].first][cells[back].second] = best;
                    back--;
                }
            }

            // Re-run normal DP after special relaxation
            relaxGrid();
        }

        return cost[0][0];
    }
};