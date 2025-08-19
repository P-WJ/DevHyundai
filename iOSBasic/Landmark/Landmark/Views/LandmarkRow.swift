//
//  LandmarkRow.swift
//  Landmark
//
//  Created by wj on 8/18/25.
//

import SwiftUI

struct LandmarkRow: View {
    var landmark: Landmark
    
    var body: some View {
        HStack {
            landmark.image
                .resizable()
                .frame(width: 50, height: 50)
            Text(landmark.name)
            Spacer()
        }
    }
}

#Preview("그룹") {
    Group {
        LandmarkRow(landmark: landmarks[0])
        LandmarkRow(landmark: landmarks[1])
    }
}

#Preview("N서울타워") {
    LandmarkRow(landmark: landmarks[0])
}

#Preview("경복궁") {
    LandmarkRow(landmark: landmarks[1])
}
