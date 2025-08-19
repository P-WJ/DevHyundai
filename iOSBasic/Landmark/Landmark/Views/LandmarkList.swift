//
//  LandmarkList.swift
//  Landmark
//
//  Created by wj on 8/19/25.
//

import SwiftUI

struct LandmarkList: View {
    var body: some View {
        NavigationSplitView {
            List(landmarks) { landmark in
                NavigationLink {
                    LandmarkDetail(landmark: landmark)
                } label: {
                    LandmarkRow(landmark: landmark)
                }
            }
            .navigationTitle("관광명소")
        } detail: {
            Text("관광명소를 선택해주세요.")
        }
    }
}

#Preview {
    LandmarkList()
}
