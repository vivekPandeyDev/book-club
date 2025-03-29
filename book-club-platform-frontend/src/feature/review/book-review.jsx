import { Avatar, AvatarFallback } from "@/components/ui/avatar";
import { Button } from "@/components/ui/button";
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card";
import { reviews } from "@/lib/db";
import { GetStarRating } from "../util/start-util";



export default function BookReviews() {
  return (
    <>
      <Button className="my-4 bg-amber-400 text-gray-900 dark:text-gray-700">
        Give a Review
      </Button>
      <div className="grid grid-cols-1 gap-2">
        {reviews.map((review) => (
          <Card key={review.id}>
            <CardHeader className="flex flex-row items-center gap-4">
              <Avatar>
                <AvatarFallback>{review.avatar}</AvatarFallback>
              </Avatar>
              <div>
                <CardTitle className="text-sm font-medium">
                  {review.username}
                </CardTitle>
                <div className="flex items-center gap-1">
                  <GetStarRating
                    rating={review.rating}
                    color={"text-red-500"}
                  />
                </div>
                <p className="text-xs text-gray-500">{review.time}</p>
              </div>
            </CardHeader>
            <CardContent>
              <p className="font-semibold">{review.title}</p>
              <p className="text-sm">{review.content}</p>
            </CardContent>
          </Card>
        ))}
      </div>
    </>
  );
}
