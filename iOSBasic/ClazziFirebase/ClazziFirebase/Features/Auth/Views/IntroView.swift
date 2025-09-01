//
//  IntroView.swift
//  Clazzi2
//
//  Created by wj on 9/1/25.
//

import SwiftUI

struct IntroView: View {
    var body: some View {
        ZStack {
            Color.black
                .edgesIgnoringSafeArea(.all)
            Image("clazzi")
        }
    }
}

#Preview {
    IntroView()
}
