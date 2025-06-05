class Twitter {
    private static int timestamp=0;
    private class User{
        int id;
        Set<Integer> followed;
        Tweet tweethead;
        public User(int id)
        {
            this.id=id;
            followed=new HashSet<>();
            follow(id);//follow himself
            tweethead=null;
        }
        public void follow(int id)
        {
            followed.add(id);
        }
        public void unfollow(int id)
        {
            if(id!=this.id)
            {
                followed.remove(id);
            }
        }
        public void post(int id)
        {
            Tweet newtweet=new Tweet(id);
            newtweet.next=tweethead;
            tweethead=newtweet;
        }
    }

    private class Tweet{
        int id;
        int time;
        Tweet next;

        public Tweet(int id)
        {
            this.id=id;
            time=timestamp++;
            next=null;
        }
    }
    private Map<Integer, User> userMap;

    public Twitter() {
        userMap=new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!userMap.containsKey(userId))
        {
            User newuser=new User(userId);
            userMap.put(userId,newuser);
        }
        userMap.get(userId).post(tweetId);
    }
    //tp 10 most recent tweets
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> newsfeed=new LinkedList<>();
        if(!userMap.containsKey(userId)) return newsfeed;
        Set<Integer> followedusers=userMap.get(userId).followed;
        PriorityQueue<Tweet> tweetheap=new PriorityQueue<>(followedusers.size(), (a,b)-> b.time-a.time);

        for(int user: followedusers)
        {
            Tweet tweet=userMap.get(user).tweethead;
            if(tweet!=null)
            {
                tweetheap.add(tweet);
            }
        }
        int count=0;
        while(!tweetheap.isEmpty() && count<10)
        {
            Tweet tweet=tweetheap.poll();
            newsfeed.add(tweet.id);
            count++;
            if(tweet.next!=null)
            {
                tweetheap.add(tweet.next);
            }
        }
        return newsfeed;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId))
        {
            User newuser=new User(followerId);
            userMap.put(followerId,newuser);
        }
        if(!userMap.containsKey(followeeId))
        {
            User newuser=new User(followeeId);
            userMap.put(followeeId,newuser);
        }
        userMap.get(followerId).follow(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(userMap.containsKey(followerId) && followerId!=followeeId)
        {
            userMap.get(followerId).unfollow(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */