import Foundation

// ---------------------------
// 학생 데이터
// ---------------------------
let names = ["폰세", "와이스", "류현진", "문동주", "황준서"]
let scores = [85, 73, 92, 65, 100]

// ---------------------------
// 1. 점수에 따른 등급 반환 함수
// ---------------------------
func assignGrade(score: Int) -> String {
    switch score {
    case 90...100:
        return "A"
    case 80..<90:
        return "B"
    case 70..<80:
        return "C"
    case 60..<70:
        return "D"
    default:
        return "F"
    }
}

// ---------------------------
// 2. 평균 점수 계산 함수
// ---------------------------
func calculateAverage(scores: [Int]) -> Double {
    var total = 0
    for score in scores {
        total += score
    }
    return Double(total) / Double(scores.count)
}

// ---------------------------
// 3. 최고 점수 학생 찾기 함수
// ---------------------------
func findMaxStudent(names: [String], scores: [Int]) -> (String, Int) {
    var maxScore = -1
    var maxName = ""
    for i in 0..<scores.count {
        if scores[i] > maxScore {
            maxScore = scores[i]
            maxName = names[i]
        }
    }
    return (maxName, maxScore)
}

// ---------------------------
// 4. 최저 점수 학생 찾기 함수
// ---------------------------
func findMinStudent(names: [String], scores: [Int]) -> (String, Int) {
    var minScore = 101
    var minName = ""
    for i in 0..<scores.count {
        if scores[i] < minScore {
            minScore = scores[i]
            minName = names[i]
        }
    }
    return (minName, minScore)
}

// ---------------------------
// 5. 등급 분포 카운트 함수
// ---------------------------
func countGrades(scores: [Int]) -> (Int, Int, Int, Int, Int) {
    var gradeA = 0, gradeB = 0, gradeC = 0, gradeD = 0, gradeF = 0
    for score in scores {
        switch score {
        case 90...100: gradeA += 1
        case 80..<90: gradeB += 1
        case 70..<80: gradeC += 1
        case 60..<70: gradeD += 1
        default: gradeF += 1
        }
    }
    return (gradeA, gradeB, gradeC, gradeD, gradeF)
}

// ---------------------------
// 6. 평균 이상 학생 찾기 함수
// ---------------------------
func findAboveAverage(names: [String], scores: [Int], average: Double) -> [String] {
    var result = [String]()
    for i in 0..<names.count {
        if Double(scores[i]) >= average {
            result.append(names[i])
        }
    }
    return result
}

// ---------------------------
// 7. 가장 많은 등급 찾기 함수
// ---------------------------
func findMostFrequentGrade(gradeCounts: (Int, Int, Int, Int, Int)) -> (String, Int) {
    let grades = ["A", "B", "C", "D", "F"]
    let counts = [gradeCounts.0, gradeCounts.1, gradeCounts.2, gradeCounts.3, gradeCounts.4]
    var maxCount = -1
    var maxGrade = ""
    for i in 0..<counts.count {
        if counts[i] > maxCount {
            maxCount = counts[i]
            maxGrade = grades[i]
        }
    }
    return (maxGrade, maxCount)
}

// ---------------------------
// 메인 실행 부분
// ---------------------------
print("학생 성적 보고서")
for i in 0..<names.count {
    let grade = assignGrade(score: scores[i])
    print("\(names[i]): \(scores[i])점, 등급: \(grade)")
}

let average = calculateAverage(scores: scores)
let (maxName, maxScore) = findMaxStudent(names: names, scores: scores)
let (minName, minScore) = findMinStudent(names: names, scores: scores)

print("\n평균 점수: \(String(format: "%.2f", average))")
print("최고 점수: \(maxName) (\(maxScore)점)")
print("최저 점수: \(minName) (\(minScore)점)")

let gradeCounts = countGrades(scores: scores)
print("\n등급 분포")
print("A: \(gradeCounts.0)명")
print("B: \(gradeCounts.1)명")
print("C: \(gradeCounts.2)명")
print("D: \(gradeCounts.3)명")
print("F: \(gradeCounts.4)명")

let aboveAverage = findAboveAverage(names: names, scores: scores, average: average)
print("\n평균 이상 학생: \(aboveAverage.joined(separator: ", "))")

let (mostGrade, mostCount) = findMostFrequentGrade(gradeCounts: gradeCounts)
print("가장 많은 등급: \(mostGrade) (\(mostCount)명)")
