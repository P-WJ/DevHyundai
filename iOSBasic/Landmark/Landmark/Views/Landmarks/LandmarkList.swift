//
//  LandmarkList.swift
//  Landmark
//
//  Created by wj on 8/19/25.
//

import SwiftUI

struct LandmarkList: View {
    @Environment(ModelData.self) var modelData
    @State private var showFavoriteOnly: Bool = false
    
    var filteredLandmarks: [Landmark] {
        modelData.landmarks.filter { landmark in
            (!showFavoriteOnly || landmark.isFavorite)}
    }
    
    var body: some View {
        NavigationSplitView {
            List() {
                Toggle(isOn: $showFavoriteOnly) {
                    Text("즐겨찾기만 보기")
                }
                
                ForEach(filteredLandmarks) { landmark in
                    NavigationLink {
                        LandmarkDetail(landmark: landmark)
                    } label: {
                        LandmarkRow(landmark: landmark)
                    }
                }
            }
            .animation(.default, value: filteredLandmarks)
            .navigationTitle("관광명소")
        } detail: {
            Text("관광명소를 선택해주세요.")
        }
    }
}

#Preview {
    LandmarkList()
        .environment(ModelData())
}
