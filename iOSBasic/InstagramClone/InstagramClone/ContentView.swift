//
//  ContentView.swift
//  InstagramClone
//
//  Created by wj on 8/19/25.
//

import SwiftUI

struct Post: Identifiable {
    var id = UUID()
    var username: String
    var userImage: String
    var postImage : String
    var likeCount: Int
    var caption: String
    var timeAgo: String
}
struct ContentView: View {
    let samaplePosts = [
      Post(username: "alice", userImage: "postImg", postImage: "postImg", likeCount: 12, caption: "Today I went for a hike! #nature #hiking", timeAgo: "1h"),
      Post(username: "bob", userImage: "postImg", postImage: "postImg", likeCount: 84, caption: "Just finished a marathon! #running #fitness", timeAgo: "2d"),
      Post(username: "chris", userImage: "postImg", postImage: "postImg", likeCount: 321, caption: "Sunset at the beach! #beach #sunset", timeAgo: "3w"),
    ]
    
    var body: some View {
        NavigationStack {
            ScrollView {
                LazyVStack {
                    ForEach(samaplePosts) { post in
                        FeedCardView(post: post)
                    }
                }
            }
        }
    }
}

struct FeedCardView: View {
    var post: Post
    
    var body: some View {
        VStack(alignment: .leading, spacing: 8) {
            HStack() {
                Image(post.userImage)
                    .resizable()
                    .clipShape(Circle())
                    .frame(width: 40, height: 40)
                    .padding(.leading)
                Text(post.username)
                Spacer()
                Image(systemName: "ellipsis")
            }
            Image(post.postImage)
                .resizable()
                .frame(width: .infinity, height: 300)
                .scaledToFill()
                .clipped()
            HStack {
                Image(systemName: "heart")
                Image(systemName: "bubble.right")
                Image(systemName: "paperplane")
                Spacer()
                Image(systemName: "bookmark")
            }
            Text("좋아요 \(post.likeCount)개")
        }
    }
}

#Preview {
    ContentView()
}
