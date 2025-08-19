import SwiftUI

// MARK: - 모델
struct Post: Identifiable {
    let id = UUID()
    let userName: String
    let userImage: String
    let postImage: String
    let likeCount: Int
    let caption: String
    let timeAgo: String
}

// MARK: - 샘플 데이터
let samplePosts: [Post] = [
    Post(
        userName: "__imamonkey|||",
        userImage: "person.circle.fill",
        postImage: "monkey",
        likeCount: 123,
        caption: "SwiftUI로 인스타그램 클론 만들기 연습 중!",
        timeAgo: "2시간 전"
    ),
    Post(
        userName: "keonthepeach",
        userImage: "person.circle.fill",
        postImage: "surfing",
        likeCount: 987,
        caption: "서핑 가고 싶네...",
        timeAgo: "어제"
    ),
    Post(
        userName: "developer_john",
        userImage: "person.circle.fill",
        postImage: "developer",
        likeCount: 456,
        caption: "오늘도 코딩 열심히!",
        timeAgo: "3시간 전"
    )
]

// MARK: - ContentView
struct ContentView: View {
    var body: some View {
        NavigationStack {
            ScrollView {
                LazyVStack(spacing: 24) {
                    ForEach(samplePosts) { post in
                        NavigationLink(destination: PostDetailView(post: post)) {
                            FeedCardView(post: post)
                        }
                        .buttonStyle(.plain)
                    }
                }
                .padding(.top, 8)
            }
            .background(Color(.systemGroupedBackground))
            .navigationTitle("Feed")
        }
    }
}

// MARK: - FeedCardView
struct FeedCardView: View {
    let post: Post
    
    var body: some View {
        VStack(alignment: .leading, spacing: 0) {
            // Header
            HStack {
                Image(systemName: post.userImage)
                    .resizable()
                    .scaledToFit()
                    .frame(width: 36, height: 36)
                    .clipShape(Circle())
                Text(post.userName)
                    .font(.subheadline)
                    .fontWeight(.semibold)
                Spacer()
                Image(systemName: "ellipsis")
            }
            .padding(.horizontal, 12)
            .padding(.vertical, 10)
            
            // Post Image
            Image(post.postImage)
                .resizable()
                .frame(width: .infinity, height: 300)
                .scaledToFill()
                .clipped()
                .background(Color.gray.opacity(0.3))
            
            // Action Buttons
            HStack(spacing: 16) {
                Image(systemName: "heart")
                    .font(.title3)
                Image(systemName: "bubble.right")
                    .font(.title3)
                Image(systemName: "paperplane")
                    .font(.title3)
                Spacer()
                Image(systemName: "bookmark")
                    .font(.title3)
            }
            .padding(.horizontal, 12)
            .padding(.vertical, 8)
            
            // Likes
            Text("좋아요 \(post.likeCount)개")
                .font(.subheadline)
                .fontWeight(.semibold)
                .padding(.horizontal, 12)
                .padding(.bottom, 4)
            
            // Caption
            Text("\(post.userName) \(post.caption)")
                .font(.subheadline)
                .lineLimit(2)
                .padding(.horizontal, 12)
            
            // Time
            Text(post.timeAgo)
                .font(.caption)
                .foregroundColor(.secondary)
                .padding(.horizontal, 12)
                .padding(.vertical, 6)
        }
        .background(Color(.systemBackground))
    }
}

// MARK: - PostDetailView
struct PostDetailView: View {
    let post: Post
    
    var body: some View {
        VStack {
            Text(post.caption)
                .font(.body)
                .padding()
            Spacer()
        }
        .navigationTitle("Post Detail")
        .navigationBarTitleDisplayMode(.inline)
    }
}

// MARK: - Preview
#Preview {
    ContentView()
}
