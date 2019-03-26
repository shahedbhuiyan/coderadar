import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import * as moment from 'moment';
import {CommitType} from '../../../model/enum/CommitType';
import {Commit} from '../../../model/commit';

@Component({
    selector: 'app-commit-chooser',
    templateUrl: './commit-chooser.component.html',
    styleUrls: ['./commit-chooser.component.scss']
})
export class CommitChooserComponent implements OnInit {

    @Input() commitType: CommitType;
    @Input() commits: Commit[];
    @Input() selected: Commit;
    @Input() loading: boolean;
    @Input() isDisabled: boolean;

    @Output() changeCommit = new EventEmitter();

    constructor() {
    }

    ngOnInit() {
    }

    handleCommitChanged(chosenModel: Commit) {
        this.changeCommit.emit({commitType: this.commitType, commit: chosenModel});
    }

    formatCommit(data: any): string {
        const formattedDateAndTime = moment(data.timestamp).format('DD.MM.YYYY HH:mm');
        return `${formattedDateAndTime} ${data.author}, ${data.name}`;
    }

}
