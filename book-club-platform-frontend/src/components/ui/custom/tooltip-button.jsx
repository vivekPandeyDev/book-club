import { FolderClosed } from "lucide-react";
import { Link } from "react-router";
import { Tooltip, TooltipContent, TooltipProvider, TooltipTrigger } from "../tooltip";

function IconButtonWithTooltip({ link = "#", children = <FolderClosed />, tooltipText = "default" }) {
  return (
    <TooltipProvider delayDuration={100}>
      <Tooltip>
        <TooltipTrigger asChild>
          <Link to={link}>
            {children}
          </Link>
        </TooltipTrigger>
        <TooltipContent side="top">
          <span>{tooltipText}</span>
        </TooltipContent>
      </Tooltip>
    </TooltipProvider>
  );
}

export default IconButtonWithTooltip;
