/*
 * Copyright OpenSearch Contributors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.opensearch.neuralsearch.util;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.opensearch.Version;
import org.opensearch.cluster.ClusterState;
import org.opensearch.cluster.node.DiscoveryNodes;
import org.opensearch.cluster.service.ClusterService;

public class NeuralSearchClusterTestUtils {

    /**
     * Create new mock for ClusterService
     * @param version min version for cluster nodes
     * @return
     */
    public static ClusterService mockClusterService(final Version version) {
        ClusterService clusterService = mock(ClusterService.class);
        ClusterState clusterState = mock(ClusterState.class);
        when(clusterService.state()).thenReturn(clusterState);
        DiscoveryNodes discoveryNodes = mock(DiscoveryNodes.class);
        when(clusterState.getNodes()).thenReturn(discoveryNodes);
        when(discoveryNodes.getMinNodeVersion()).thenReturn(version);
        return clusterService;
    }
}
