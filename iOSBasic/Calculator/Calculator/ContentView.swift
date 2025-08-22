//
//  ContentView.swift
//  Calculator
//
//  Created by wj on 8/20/25.
//

import SwiftUI

struct ContentView: View {
    @State var display: String = ""
    @State var inputA: String = ""
    @State var inputB: String = ""
    @State var operatorSign: String = ""
    
    // 버튼 레이블 배열
    let labels: Array<Character> = [
        "7", "8", "9", "/",
        "4", "5", "6", "*",
        "1", "2", "3", "-",
        "C", "0", "=", "+"
    ]
    
    func buttonClicked(_ char: Character) {
        if inputA == "" {
            display = ""
        }
        switch char {
        case "C":
            display = ""
            clear()
            
        case "=":
            print(char)
//            let result: Int = Int(inputA)! + Int(inputB)!
//            display += "=\(result)" // String(result)!
//            display.append(contentsOf: "=\(result)")
            let result = calculate()
            if let result = result {
                display.append(result)
            } else {
                print("형변환이 제대로 되지 않았거나, 0으로 나누었습니다.")
            }
            clear()
            
        case "+", "-", "*", "/":
            display.append(contentsOf: String(char))
            operatorSign = String(char)
            
        default:
            display.append(contentsOf: String(char))
            if operatorSign.isEmpty {
                inputA.append(contentsOf: String(char))
            } else {
                inputB.append(contentsOf: String(char))
            }
            print(inputA, inputB)
        }
    }
    
    func clear() {
        inputA = ""
        inputB = ""
        operatorSign = ""
    }
    
    func calculate() -> String? {
        let a: Int? = Int(inputA)
        let b: Int? = Int(inputB)
        
        // 함수 안에서는 guard-let을 통한 옵셔널 바인딩을 한다.
        guard let a = Int(inputA), let b = Int(inputB) else {
            print("정수형으로 변환되지 않습니다.")
            return nil
        }
        
        var result: Int = 0
        
        switch operatorSign {
        case "+":
            result = a + b
        case "-":
            result = a - b
        case "*":
            result = a * b
        case "/":
            if b == 0 {
                return nil
            }
            result = a / b
        default:
            print("???")
        }
        return "=\(result)"
//        display.append("=\(result)")
    }
    var body: some View {
        NavigationStack {
            VStack {
                HStack {
                    Spacer()
                    Text(display)
                        .font(.system(size: 30))
                        .padding()
                }
                //            .frame(maxWidth: .infinity, minHeight: 200)
                
                Spacer()
                    .frame(height: 100)
                
                let columns = Array(repeating: GridItem(.flexible(), spacing:12), count: 4)
                
                LazyVGrid(columns: columns, spacing: 12) {
                    ForEach(labels, id: \.self) { label in
                        Button(action: {
                            buttonClicked(label)
                        }) {
                            Text(String(label))
                                .font(.system(size: 20))
                                .frame(maxWidth: .infinity, minHeight: 64)
                                .background(Color(.systemGray5))
                                .clipShape(RoundedRectangle(cornerRadius: 12))
                            
                        }
                    }
                }
            }
            .padding()
            .navigationTitle("계산기")
        }
    }
}

#Preview {
    ContentView()
}
