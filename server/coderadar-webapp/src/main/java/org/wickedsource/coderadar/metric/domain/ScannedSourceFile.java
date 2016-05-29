package org.wickedsource.coderadar.metric.domain;

import org.wickedsource.coderadar.analyzer.api.ChangeType;

import javax.persistence.*;

@Entity
public class ScannedSourceFile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @Enumerated(EnumType.STRING)
    private ChangeType changeType;

    @Column
    private String filepath;

    @Column
    private String filepathBeforeRename;

    @Column
    private String commitName;

    @Column
    private String parentCommitName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ChangeType getChangeType() {
        return changeType;
    }

    public void setChangeType(ChangeType changeType) {
        this.changeType = changeType;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public String getFilepathBeforeRename() {
        return filepathBeforeRename;
    }

    public void setFilepathBeforeRename(String filepathBeforeRename) {
        this.filepathBeforeRename = filepathBeforeRename;
    }

    public String getCommitName() {
        return commitName;
    }

    public void setCommitName(String commitName) {
        this.commitName = commitName;
    }

    public String getParentCommitName() {
        return parentCommitName;
    }

    public void setParentCommitName(String parentCommitName) {
        this.parentCommitName = parentCommitName;
    }
}
