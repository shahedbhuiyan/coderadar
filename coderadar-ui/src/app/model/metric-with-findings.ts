import {Finding} from './finding';

export class MetricWithFindings {
  public name: string;
  public description: string;
  public value: number;
  public findings: Finding[];
}
