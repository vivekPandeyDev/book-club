import { Alert, AlertDescription } from "@/components/ui/alert";
import { Avatar, AvatarFallback } from "@/components/ui/avatar";
import {
  Card,
  CardContent,
  CardHeader,
  CardTitle,
} from "@/components/ui/card";
import { AlertTriangle } from "lucide-react";

// Sample JSON Data for Discussions
const discussions = [
  {
    id: 1,
    username: "cultinov",
    time: "about 4 hours ago",
    avatar: "CU",
    content: "I read this sentence in Ch.13 when some seniors who are supposed to fight with freshmen in the sect entrance test lose to MC and tell him they usually loot the new disciples, etc. But after the entrance test one elder finds out...",
    replies: []
  },
  {
    id: 2,
    username: "kuramashi200",
    time: "about 11 hours ago",
    avatar: "KU",
    content: "All China work the same. There is no unique novel. Some antagonists just say hatred, grudge, etc... I left reading.",
    replies: [
      {
        id: 21,
        username: "readingmaniac",
        time: "about 2 hours ago",
        avatar: "RM",
        content: "IKR, there are rarely any new ideas. That goes for Korean & Japanese novels too. Just add a twist, at least!"
      },
      {
        id: 21,
        username: "readingmaniac",
        time: "about 2 hours ago",
        avatar: "RM",
        content: "IKR, there are rarely any new ideas. That goes for Korean & Japanese novels too. Just add a twist, at least!"
      }
    ]
  },
  {
    id: 3,
    username: "mofan181",
    time: "about 13 hours ago",
    avatar: "MO",
    content: "Good start, MC becomes stronger fast. But after joining the Sect and facing demons, he loses his edge. Felt slow after that.",
    replies: []
  }
];

export default function BookDiscussion() {
  return (
    <div className="px-4 py-8">
      
      {/* Alerts */}
      <div className="grid grid-cols-1 gap-2">
        <Alert variant="default" className="bg-yellow-700">
          <AlertTriangle className="h-5 w-5" />
          <AlertDescription className="text-yellow-100">
            Attempting to bypass censored words or links will result in a ban.
          </AlertDescription>
        </Alert>
        <Alert className="bg-yellow-700">
          <AlertTriangle className="h-5 w-5" />
          <AlertDescription className="text-yellow-100">
            Please keep the discussion relevant to the book and stay on topic.
          </AlertDescription>
        </Alert>
      </div>

      {/* Login Notice */}
      <p className="text-center text-yellow-600 font-semibold text-lg my-6">
        You need to login to comment.
      </p>

      {/* Discussions Header */}
      <h2 className="text-2xl font-semibold mb-6">Discussions ({discussions.length})</h2>

      <div className="grid grid-cols-1 gap-2">
        {discussions.map((discussion) => (
          <Card key={discussion.id} className="border bg-gray-100 dark:bg-gray-800">
            <CardHeader className="flex flex-row items-center gap-3">
              <Avatar className="h-8 w-8">
                <AvatarFallback>{discussion.avatar}</AvatarFallback>
              </Avatar>
              <div>
                <CardTitle className="text-sm font-medium">{discussion.username}</CardTitle>
                <p className="text-xs">{discussion.time}</p>
              </div>
            </CardHeader>
            <CardContent>
              <p className="text-sm">{discussion.content}</p>
              <button className="mt-2 text-blue-600 text-sm hover:underline">Read More</button>
              <p className="mt-2 text-sm  hover:underline cursor-pointer">↪ Reply</p>
            </CardContent>

            {/* Render Replies */}
            {discussion.replies.length > 0 && (
              <div className="ml-6 border-l-4 border-teal-500 pl-4 space-y-4 pr-2">
                {discussion.replies.map((reply) => (
                  <Card key={reply.id} className="border bg-gray-100 dark:bg-gray-700">
                    <CardHeader className="flex flex-row items-center gap-3">
                      <Avatar className="h-8 w-8">
                        <AvatarFallback>{reply.avatar}</AvatarFallback>
                      </Avatar>
                      <div>
                        <CardTitle className="text-sm font-medium">{reply.username}</CardTitle>
                        <p className="text-xs ">{reply.time}</p>
                      </div>
                    </CardHeader>
                    <CardContent>
                      <p className="text-sm">{reply.content}</p>
                      <button className="mt-2 text-blue-600 text-sm hover:underline">Read More</button>
                    </CardContent>
                  </Card>
                ))}
              </div>
            )}
          </Card>
        ))}
      </div>
    </div>
  );
}
