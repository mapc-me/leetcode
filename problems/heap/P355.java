package heap;

import java.util.*;

public class P355 {

    public static void main(String[] args) {
        Twitter twitter = new Twitter();

//        twitter.postTweet(1, 5);
//        System.out.println(twitter.getNewsFeed(1));
//        twitter.follow(1, 2);
//        twitter.postTweet(2, 6);
//        twitter.postTweet(2, 7);
//        twitter.postTweet(2, 8);
//        twitter.postTweet(2, 9);
//        twitter.postTweet(2, 10);
//        twitter.postTweet(1, 1);
//        System.out.println(twitter.getNewsFeed(1));
//        twitter.unfollow(1, 2);
//        System.out.println(twitter.getNewsFeed(1));

//        twitter.follow(1, 5);
//        System.out.println(twitter.getNewsFeed(1));
//        twitter.follow(2, 1);
//        System.out.println(twitter.getNewsFeed(2));
//        twitter.unfollow(2, 1);
//        System.out.println(twitter.getNewsFeed(2));

        twitter.postTweet(1, 5);
        System.out.println(twitter.getNewsFeed(1));
        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        System.out.println(twitter.getNewsFeed(1));
    }


    static class Twitter {

        int counter = 0;
        final int MOST_POPULAR_NUMBER = 10;

        static class Twit {
            int userId;
            int id;
            int counter;

            public Twit(int userId, int id, int counter) {
                this.userId = userId;
                this.id = id;
                this.counter = counter;
            }

            @Override
            public String toString() {
                return "{" +
                        "userId=" + userId +
                        ", id=" + id +
                        ", counter=" + counter +
                        '}';
            }
        }

        Map<Integer, Set<Integer>> followers;
        Map<Integer, PriorityQueue<Twit>> userTwitsHeap = new HashMap<>();

        public Twitter() {
            followers = new HashMap<>();
        }

        public void postTweet(int userId, int tweetId) {
            if (!userTwitsHeap.containsKey(userId)) {
                userTwitsHeap.put(userId, new PriorityQueue<>((a, b) -> b.counter - a.counter));
            }
            userTwitsHeap.get(userId).offer(new Twit(userId, tweetId, counter++));
        }

        public List<Integer> getNewsFeed(int userId) {
            PriorityQueue<Twit> heap = new PriorityQueue<>(
                    Optional.ofNullable(userTwitsHeap.get(userId))
                            .orElse(new PriorityQueue<>((a, b) -> b.counter - a.counter))
            );
            followers.getOrDefault(userId, Collections.emptySet())
                    .forEach(userFollowers -> {
                        PriorityQueue<Twit> followerTwitHeap = Optional.ofNullable(userTwitsHeap.get(userFollowers))
                                .orElse(new PriorityQueue<>((a, b) -> b.counter - a.counter));
                        heap.addAll(followerTwitHeap);
                    });
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < MOST_POPULAR_NUMBER && !heap.isEmpty(); i++) {
                result.add(heap.poll().id);
            }
            return result;
        }

        public void follow(int followerId, int followeeId) {
            if (!followers.containsKey(followerId)) {
                followers.put(followerId, new HashSet<>());
            }
            followers.get(followerId).add(followeeId);
        }

        public void unfollow(int followerId, int followeeId) {
            if (!followers.containsKey(followerId)) {
                return;
            }
            followers.get(followerId).remove(followeeId);
        }
    }

}
