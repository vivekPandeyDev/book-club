import { Button } from "@/components/ui/button";
import { Card, CardContent } from "@/components/ui/card";
import { Maximize, Minus, Plus } from "lucide-react";
import { useRef, useState } from "react";

const bookPages = [
  `Once upon a time, in a land far away, there was a small village where the people lived in harmony with nature. The trees whispered secrets to those who listened, and the rivers carried stories from distant lands. It was a place untouched by the modern world Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nihil vero suscipit molestias praesentium, maiores iure nobis id accusamus pariatur minus nisi dolores? Nisi obcaecati velit recusandae repellat impedit aliquam expedita!
Amet sit soluta voluptates totam reiciendis numquam nemo iure quibusdam repellat, incidunt modi id quia odit quo? Assumenda voluptatem iusto eum, temporibus eius iste, rem possimus quasi, amet sed laudantium!
Quidem, maiores quaerat tenetur sint autem quos repellat soluta ut repudiandae nesciunt molestias. Quia reprehenderit rerum voluptas molestias aut nemo dignissimos sint, rem porro blanditiis doloribus, quae nisi! Autem, fuga.
Unde nihil voluptates officia velit tempora fuga, magnam minus dignissimos modi sit, reprehenderit distinctio? In libero aut similique temporibus maxime. Soluta eos aut, excepturi magnam accusantium laudantium temporibus doloribus consequatur!
Atque sit accusantium nostrum porro ad exercitationem doloribus, asperiores rem! Officiis soluta in enim mollitia, aspernatur deleniti molestiae. Repellat dignissimos facere enim quia rerum laboriosam reiciendis eaque libero tenetur. Voluptatum.
Veniam, sapiente deleniti accusantium modi necessitatibus ducimus? Dolor, reiciendis suscipit. Ut quos rem cupiditate magni eligendi officia sed maiores ipsa quas, ducimus ab, perferendis consequuntur possimus error, amet architecto aperiam.
Laboriosam, qui consequatur! Commodi vitae quae ullam voluptates! Culpa, voluptates rem doloremque quaerat recusandae dolores officia eaque architecto accusantium voluptas iure et consectetur qui eos itaque sint esse officiis enim.
Exercitationem a mollitia, consectetur voluptates eos fuga. Eos aspernatur tempore doloremque nulla sequi vero quis ipsum maxime. Adipisci cum dolores recusandae, nihil neque minus eius odit, tempora id distinctio consectetur?
Delectus, facere facilis quasi quod iusto nemo aliquid nesciunt, sit excepturi iure quas, quisquam optio libero expedita quis magni! Iste quod exercitationem nobis enim eligendi deserunt incidunt ad pariatur ea?
Vel tempore officia, quam delectus ipsam nostrum odio vitae ullam fugit iste saepe illum quasi possimus, totam sequi cumque harum nulla cum animi. Aspernatur dolorum velit fugit repellat a? Aspernatur.
Tempore quia id eligendi aliquam minus provident explicabo animi laborum, sint amet non beatae ullam placeat quae autem iste blanditiis doloremque delectus harum vitae itaque in mollitia impedit facilis! Quam!
Illo, repellendus! Id alias illum fugit, quae possimus distinctio voluptatum earum assumenda cumque, vel magnam dignissimos nihil eaque, veniam obcaecati porro. Iusto molestias molestiae, veniam iure possimus illum veritatis pariatur.
Laboriosam ut repudiandae hic aspernatur sunt ea voluptatum commodi repellendus distinctio, aliquam ratione. Et, ex id ea quam explicabo ut earum recusandae veniam eveniet dolore sunt dolorum blanditiis dolor officia!
Sunt quisquam nam et est iste ipsam rem dicta esse fuga ullam molestias nihil officiis consequatur modi harum consectetur libero, ratione accusamus soluta facilis. Placeat est delectus odit asperiores itaque.
Iusto voluptatum quae officia necessitatibus! Rerum culpa, exercitationem quia dolore amet, natus reprehenderit adipisci corporis repellat sunt dicta iure ullam earum officia inventore laboriosam fugit repellendus a minima eum quidem!
Quas, perferendis tempora nam provident minima aliquid cupiditate quidem soluta consequatur magni dicta cum nemo doloribus cumque unde architecto laudantium inventore. Quis maiores id esse inventore officiis dolorum nisi quam.
Nisi non itaque similique necessitatibus error voluptatem, reiciendis debitis tempora quo laudantium eos maiores? Iusto ut, doloribus quisquam officiis excepturi architecto quam debitis quia laborum pariatur eligendi, nam unde adipisci!
Dicta impedit consequuntur harum excepturi fugiat porro, sapiente delectus vero, alias dolorum a. Aliquam eius perspiciatis et commodi quasi in provident nihil. Perferendis deserunt repudiandae sequi cum nostrum dolorum veniam?
Aut quos explicabo obcaecati commodi ipsam adipisci totam quia, natus nesciunt ullam aliquam ratione suscipit sunt placeat, eligendi, sed laudantium odit exercitationem doloremque sequi sit cupiditate porro nisi? Quo, ipsa.
Voluptate, similique. Deleniti corporis, expedita accusantium exercitationem ullam tempore fugit cumque magni fugiat quia, doloremque reiciendis cum dolorem laborum neque quam accusamus eos. Inventore sapiente, sed reiciendis saepe officia dolorem!
Ad necessitatibus perspiciatis praesentium consequatur doloribus blanditiis odit soluta saepe, repudiandae quisquam distinctio inventore voluptate accusantium amet iste ipsum, officia doloremque porro incidunt eaque rerum cupiditate tempore aliquam. Illum, nobis!
Praesentium, minus reiciendis. Facere animi natus, ullam reprehenderit laboriosam deserunt fuga, odit error voluptates possimus tempora, excepturi tenetur. Necessitatibus neque porro magni tenetur quaerat quas fugiat qui dolores quibusdam asperiores?
Vitae, magni necessitatibus explicabo assumenda reiciendis fugit? Consequuntur impedit est cum nisi inventore obcaecati excepturi dolorem, ea quisquam aperiam amet fuga vero corrupti quaerat voluptas? Nesciunt assumenda voluptatem illo sint!
Ducimus velit quo tempore tempora vero illum commodi fuga debitis. Accusamus dolor ipsam provident! Sit quibusdam dicta inventore minima soluta numquam, deleniti ullam explicabo sapiente voluptates veniam assumenda! Placeat, blanditiis?
Obcaecati, vitae? Error cumque harum id odio qui porro nihil officia distinctio architecto nulla nam, inventore odit deleniti blanditiis dolorem et voluptas molestiae placeat nisi commodi repellat amet accusamus ab.
Consectetur nobis, et praesentium eius ipsa hic amet repellat. Vel est magnam pariatur asperiores ut quam voluptatum fugiat, architecto error blanditiis minus maxime omnis eos tenetur atque praesentium dolores voluptates.
Esse iusto optio illo qui laudantium accusamus ipsam tenetur pariatur suscipit magni veritatis velit, alias vel error neque iste, odit dolore explicabo? Commodi quo, quaerat eligendi maiores distinctio ad nam.
Ad quos rerum, consequuntur qui labore at itaque numquam debitis pariatur facilis ipsam enim? Pariatur quae quos magnam nulla laudantium dolorum cum maxime, nesciunt molestiae, accusamus sunt placeat dignissimos autem!
Vero nam ducimus facere voluptas veritatis non, maiores earum, distinctio et laboriosam similique dolor nulla esse neque perferendis doloribus. Exercitationem ea, ex ducimus corrupti dicta odit et perferendis voluptatibus est.
Perferendis esse adipisci accusantium nihil ex sint quis quibusdam iure quas! Quia odit excepturi voluptatibus sapiente quo consectetur veritatis numquam quis, error omnis ullam inventore fugiat possimus fuga voluptatem esse!
Porro recusandae ullam illo voluptatum expedita explicabo atque nesciunt, quam officia consectetur commodi error voluptas fugit veritatis repellat. Corrupti veniam esse dolore saepe illum deleniti ab vel tenetur laudantium aperiam.
Cum expedita, eaque rem, reiciendis officia saepe itaque excepturi, soluta alias natus veniam quae iste aliquid adipisci! Recusandae pariatur veniam eius commodi optio harum ut tempore minima iste cumque. Aspernatur!
Eaque dolorum numquam reiciendis inventore corporis expedita corrupti excepturi officiis quibusdam dicta. Ducimus perspiciatis eos ad? Saepe architecto, dolorum fuga velit minus error animi nam suscipit eius eveniet recusandae magni?
Ipsam quidem, amet nemo architecto fugit sit cum, saepe veniam distinctio ducimus, harum nam nobis. Sapiente nulla mollitia at blanditiis suscipit optio maxime dolore inventore corporis porro, quo ex libero.
Deleniti non voluptas illo aut consequuntur, praesentium necessitatibus recusandae accusamus, doloribus excepturi, dignissimos itaque in magni quidem eaque animi enim quo nesciunt. Officia molestiae quaerat odit, excepturi assumenda cum tenetur.
Commodi non, dolorum iste itaque cupiditate eveniet repellat. Quidem laboriosam repellat veniam at consectetur inventore minima porro! Nobis aliquam placeat explicabo optio quam beatae cupiditate inventore perspiciatis, quae ab? Ad.
Modi unde praesentium sint ipsam et, possimus quia, natus omnis similique alias cum magni neque excepturi. Vel ratione tenetur provident ipsam, nulla natus et, voluptatum magnam cum, neque architecto ducimus!
Fugiat quisquam nostrum nam, dolore unde nihil id laboriosam repellendus aperiam ipsam voluptates ex. Ipsam, voluptatibus asperiores mollitia harum officia cum. Adipisci reiciendis enim voluptatem soluta nihil, amet vero quasi!
Impedit deserunt optio voluptatibus quasi odit voluptas ratione corporis ad praesentium saepe, reiciendis itaque nostrum culpa deleniti quod soluta reprehenderit illum excepturi consequuntur eaque quas dolorem illo. Possimus, consectetur commodi.
Nobis officiis praesentium perferendis ea consectetur maxime, doloribus sapiente exercitationem accusamus, ducimus natus molestias facilis similique cumque laudantium error voluptates, tenetur excepturi fuga. Dolorum tempora, sequi consequatur tenetur alias odio?
Quia aperiam provident necessitatibus numquam harum repudiandae quaerat, error blanditiis deleniti ratione accusamus quidem facere cum, voluptatum, inventore est. Non, exercitationem vitae praesentium similique rem dolores doloremque soluta cum facilis.
Ipsa, consequatur vel? Magnam minima doloribus, vel mollitia alias, sed autem, expedita eius sint nemo vero incidunt earum ab facilis sunt omnis molestias cupiditate explicabo ut. Culpa quisquam quod dolore.
Eum eaque voluptate alias? Recusandae, iusto ducimus optio qui corporis fuga, sed, sit quam nam quia itaque voluptatem quas voluptas nesciunt repellat ipsa quis autem cupiditate aliquid nihil eaque ullam.
Quis voluptatum labore explicabo maxime laborum distinctio soluta a itaque, suscipit fugit, recusandae ad saepe obcaecati id tempora excepturi corporis incidunt, cumque perspiciatis eligendi! Iure sed adipisci repudiandae enim laudantium.
Facere a fugit voluptatum consequatur veritatis quisquam ratione, soluta cumque minus deleniti accusamus. Corrupti unde aliquam tempore, delectus tempora aut voluptates nostrum, nemo maxime porro alias animi ipsa culpa. Blanditiis?
Placeat natus explicabo accusantium, quasi nihil laboriosam iusto earum sequi odio dolorem eum tempore a, repellendus incidunt debitis possimus delectus esse nam, deserunt nostrum? Incidunt consequuntur quasi fugiat deserunt? Commodi.
Ex magni molestias autem aliquam totam doloribus doloremque quam distinctio sunt ab ipsa aperiam quas architecto deleniti nulla, aut dolores cumque ullam eveniet deserunt numquam? Dolorem ea sit eveniet quasi?
Officia fugiat illo quo corrupti eos, soluta omnis laudantium vel quae ab autem aliquam, ipsam maiores saepe ex eveniet incidunt sequi dolores aperiam nihil fuga veritatis! Reiciendis provident aliquam quaerat.
Quo magni nulla beatae inventore magnam ut dicta, sunt quam? Nostrum, aut dolore earum optio necessitatibus ipsum quod voluptates inventore veritatis, blanditiis, aliquid quibusdam eius iusto error asperiores dignissimos explicabo.
Quo laudantium ipsum nobis ullam perferendis delectus voluptatum repellat quia animi. Itaque sapiente dicta architecto ipsam consequuntur voluptate fugit natus sed minus inventore autem, dolore nesciunt in modi ad saepe.
Expedita laborum cum dolor ducimus consequatur dolorem labore consequuntur voluptatem repellendus eius provident tempora nobis esse ipsum repellat dolorum velit blanditiis, ratione quas quo omnis assumenda porro! Veniam, tenetur vel.
Quasi inventore repudiandae perferendis numquam suscipit nam quam neque magnam! Cupiditate minus rerum praesentium iure nostrum nisi quas, laboriosam corrupti in quae exercitationem necessitatibus totam recusandae, quo atque explicabo esse.
Quisquam odit quibusdam delectus repudiandae nostrum eum recusandae nemo architecto magnam, nihil voluptatem modi, ex laborum fugit suscipit cumque corrupti aliquid omnis, dolore incidunt optio deserunt illum! Nulla, blanditiis libero.
Illo sed distinctio harum ullam nobis ipsum autem, quidem optio amet facere, possimus sint asperiores iste itaque suscipit ex ipsa eos dolor quisquam laudantium magni accusamus voluptas magnam unde! Quas!
Maxime illo natus, nihil doloribus repellendus eum totam similique sed beatae iste accusamus consequuntur voluptates ab illum eos, minima, quod culpa adipisci obcaecati ratione vero veritatis ullam ipsam? Ducimus, quae!
Reiciendis, excepturi dolorum? Esse nam labore ipsa voluptatum reiciendis, id magni quos iusto est voluptatibus odit omnis atque! Dicta harum voluptatum illo ipsa minima consectetur architecto animi consequatur fuga! Maiores.
Soluta facere sunt magnam voluptatem dolorum perspiciatis commodi doloribus repudiandae autem fuga laborum consequuntur iure quaerat atque architecto quae distinctio exercitationem eum, itaque quisquam nostrum tempora! Pariatur sint quas temporibus?
Totam commodi temporibus asperiores? Eius corporis quis eveniet officiis aut aliquid praesentium illum quam ea qui sint, quae provident architecto magnam accusamus. At, error corrupti voluptates expedita fuga eligendi obcaecati.
Adipisci iste cum placeat alias harum, consectetur odio eveniet sed, doloribus distinctio dolorem dolores sit eum voluptatem, possimus labore sequi ad et. Quis porro quod veritatis laborum numquam ratione rem.
Fugiat quo, maxime inventore harum sint non facilis molestias est atque ab voluptates eaque dignissimos tempore praesentium ipsam at veritatis pariatur voluptatum labore, mollitia, eveniet asperiores iure! Harum, adipisci repellat? `,
  "The villagers lived peacefully, surrounded by lush forests and clear rivers. Every morning, children would run to the meadows, chasing butterflies and picking wildflowers, while elders sat under the grand oak tree, sharing tales of the past.",
  "One day, a mysterious traveler arrived, bringing stories from distant lands. He spoke of kingdoms beyond the mountains, deserts with endless golden sands, and oceans so vast they touched the sky. The villagers listened in awe, their imaginations running wild.",
  "As the sun set, the village elders gathered to hear his tales. They invited him to stay, offering him a place by the fire and a meal from their harvest. The traveler, grateful for their hospitality, shared a story that would change the village forever...",
  "The night was filled with wonder, as the stars shone bright in the sky. The traveler spoke of a hidden treasure, buried deep within the enchanted forest. The villagers, eager for adventure, made plans to set out at dawn...",
];

const fontFamilies = [
  "serif",
  "sans-serif",
  "monospace",
  "Georgia",
  "Times New Roman",
];

export default function BookReader() {
  const [page, setPage] = useState(0);
  const [fontSize, setFontSize] = useState(18);
  const [fontFamily, setFontFamily] = useState("serif");
  const readerRef = useRef(null);

  const toggleFullScreen = () => {
    if (!document.fullscreenElement) {
      readerRef.current.requestFullscreen();
    } else {
      document.exitFullscreen();
    }
  };

  const nextPage = () => setPage((p) => Math.min(p + 1, bookPages.length - 1));
  const prevPage = () => setPage((p) => Math.max(p - 1, 0));

  return (
    <div ref={readerRef} className={`flex flex-col transition-all`}>
      <h1 className="text-2xl font-bold mt-2">Book Reader 📖</h1>

      {/* Settings Bar */}
      <div className="flex justify-center gap-2 p-1 mb-2">
        <div className="flex items-center space-x-2">
          <Minus
            className="w-5 h-5 cursor-pointer"
            onClick={() => setFontSize((size) => Math.max(size - 2, 12))}
          />
          <span className="text-lg">Font Size: {fontSize}px</span>
          <Plus
            className="w-5 h-5 cursor-pointer"
            onClick={() => setFontSize((size) => Math.min(size + 2, 30))}
          />
        </div>

        <select
          value={fontFamily}
          onChange={(e) => setFontFamily(e.target.value)}
          className="px-2 py-1 border rounded text-gray-900 dark:text-gray-50"
        >
          {fontFamilies.map((font) => (
            <option key={font} value={font} className="bg-gray-700 text-white">
              {font}
            </option>
          ))}
        </select>

        <Button onClick={toggleFullScreen} variant="ghost">
          <Maximize className="w-5 h-5" />
        </Button>
      </div>

      {/* Book Content with Fixed Height & Scroll */}
      <Card className="w-full  p-6 shadow-lg">
        <CardContent
          className="text-lg overflow-y-auto w-full h-[400px] lg:h-[500px]"
          style={{
            fontSize: `${fontSize}px`,
            fontFamily,
            padding: "10px",
            lineHeight: "1.6",
          }}
        >
          {bookPages[page]}
        </CardContent>
        {/* Navigation */}
        <div className="flex justify-between mt-6">
          <Button onClick={prevPage} disabled={page === 0}>
            ← Previous
          </Button>
          <span className="text-lg">
            {page + 1} / {bookPages.length}
          </span>
          <Button onClick={nextPage} disabled={page === bookPages.length - 1}>
            Next →
          </Button>
        </div>
      </Card>
    </div>
  );
}
