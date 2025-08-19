import SwiftUI

struct CustomButton: View {
    let title: String
    let action: () -> Void
    
    var body: some View{
        Button(action: action){
            Text(title)
                .padding()
                .background(Color.blue)
                .foregroundColor(.white)
                .cornerRadius(8)
        }
    }
}
